import SwitchLanguage from '@components/switch-language.component'
import ThemeToggle from '@src/components/theme-toggle.component'
import { locales } from '@src/middleware'
import { themes } from '@src/utils/constants'
import { useTranslations } from 'next-intl'
import Link from 'next/link'

export default function Home() {
  const t = useTranslations()

  return (
    <main className="flex min-h-screen flex-col items-center gap-16 p-24">
      <h1>{t('site.title')}</h1>
      <div>
        <p>{t('site.description')}</p>
        <Link
          href="https://www.kaggle.com/datasets/momanyc/museum-collection/data"
          rel="noopener noreferrer"
          target="_blank"
          className="text-blue-500 underline"
        >
          {t('site.source')}
        </Link>
        <p>{t('site.explanation')}</p>
      </div>
      <div className="flex gap-4">
        <SwitchLanguage
          options={locales.map((locale) => ({
            value: locale,
            label: t(`language.${locale}`),
          }))}
        />
        <ThemeToggle
          options={themes.map((theme) => ({
            value: theme,
            label: t(`theme.${theme}`),
          }))}
        />
      </div>
    </main>
  )
}
